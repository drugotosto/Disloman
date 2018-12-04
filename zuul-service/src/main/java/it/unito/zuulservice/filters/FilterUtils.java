package it.unito.zuulservice.filters;

import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/*
  Custom Utility Class che racchiude le funzioni più utilizzate da tutte le diverse tipologie di filtri utilizzati
  da Zuul. Si preoccupa di controllare che nelle richieste utente in arrivo siano presenti/vengano inseriti gli HEADERS
  utilizzati poi dai microservizi di backend
  Tra i metodi utilizzati dal TrackingFilter ci sono quelli per verificare la presenza del Correlation ID
  come attributo HEADER della richiesta HTTP client e nel caso inserirla.
 */
@Component
public class FilterUtils {

    // campi che rappresentano i possibili HEADER da settare nelle richieste/risposte HTTP che passano da ZUUL
    public static final String CORRELATION_ID = "Correlation-id";
    public static final String OAUTH_TOKEN     = "Authorization";

    // campi che identificano le possibili tipologie di filtri
    public static final String PRE_FILTER_TYPE = "pre";
    public static final String POST_FILTER_TYPE = "post";


    public String getCorrelationId(){
        /*
            L'oggetto della classe RequestContext (versione specializzata della libreria Zuul rispetto a quella di
            una normale appplicazione Spring MVC 'org.springframework.web.servletsupport.RequestContext')
            è di tipo ThreadLocal (associato al thread che gestisce la richiesta HTTP originale)
            Contiene anche le informazioni presenti nelle HTTP request/response a cui i Zuul filters possono accedere.
        */
        RequestContext ctx = RequestContext.getCurrentContext();

        if (ctx.getRequest().getHeader(CORRELATION_ID) != null) {
            return ctx.getRequest().getHeader(CORRELATION_ID);
        }
        else {
            return  ctx.getZuulRequestHeaders().get(CORRELATION_ID);
        }
    }

    public void setCorrelationId(String correlationId){
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader(CORRELATION_ID, correlationId);
    }

    public final String getOauthToken(){
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.getRequest().getHeader(OAUTH_TOKEN);
    }

}
