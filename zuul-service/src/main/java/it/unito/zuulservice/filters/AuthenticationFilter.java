package it.unito.zuulservice.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class AuthenticationFilter extends ZuulFilter {

    private static final int FILTER_ORDER =  1;
    private static final boolean  SHOULD_FILTER = true;

    @Autowired
    FilterUtils filterUtils;

    // Definisce la tipologia di filtro a cui questa classe appartiene (Pre-filters, Route-filters, Post-filters)
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
        Controlla che l'utente sia già stato autenticato e presenti quindi o Authentication HEADER (Rest Client) o i Cookies (Web-based/mobile application)
        all'interno della HTTP Request ricevuta oppure presenti una richiesta di autenticazione verso l'end-point "auth/oauth/login" (Web-based/mobile application)
     */
    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.warn("Avvio dell'Authentication Filter. HTTP Metodo: {} l'URL: {}",request.getMethod(),request.getRequestURL().toString());

        if(filterUtils.getOauthToken()!=null) {
            log.warn("L'OAUTH Token è presente come HEADER della richiesta");
        }

        log.warn("L'OAUTH Token NON è presente come HEADER della richiesta");

        return  null;
    }

}
