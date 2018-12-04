package it.unito.zuulservice.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
    Rappresenta il Zuul Pre-Filter che ha il compito di verificare la presenza e nel caso generare il CorrelationID per il tracciamento
*/
@Slf4j
@Component
public class TrackingFilter extends ZuulFilter{

    private static final int FILTER_ORDER =  2;
    private static final boolean  SHOULD_FILTER = true;

    @Autowired
    FilterUtils filterUtils;

    // Dfinisce la tipologia di filtro a cui questa classe appartiene (Pre-filters, Route-filters, Post-filters)
    @Override
    public String filterType() {
        return FilterUtils.PRE_FILTER_TYPE;
    }

    // Definisce l'ordine che dovrà avere tale filtro rispetto agli altri della sua stessa tipologia
    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    // Attiva o Disattiva il Filtro
    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    /*
        Controlla che il Correlation-ID sia presente nell'HEADER della HTTP Reqeust e nel caso lo setta.
    */
    @Override
    public Object run() {
        if (isCorrelationIdPresent()) {
           log.debug("tmx-correlation-id found in tracking filters: {}. ", filterUtils.getCorrelationId());
        }
        else{
            filterUtils.setCorrelationId(generateCorrelationId());
            log.debug("tmx-correlation-id generated in tracking filters: {}.", filterUtils.getCorrelationId());
        }

        RequestContext ctx = RequestContext.getCurrentContext();
        log.debug("Processing incoming request for {}.",  ctx.getRequest().getRequestURI());
        return null;
    }

    private boolean isCorrelationIdPresent(){
        if (filterUtils.getCorrelationId() !=null) {
            log.warn("Il CorrelationID è presente come HEADER della richiesta");
            return true;
        }
        log.warn("Il CorrelationID NON è presente come HEADER della richiesta");
        return false;
    }

    // Si genera un nuovo Correlation ID random che verrà settato come attributo HEADER della richiesta HTTP client
    private String generateCorrelationId(){
        return java.util.UUID.randomUUID().toString();
    }
}