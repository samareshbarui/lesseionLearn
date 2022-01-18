package com.liferay.demo.auto.translate.rest.application;

import com.liferay.demo.auto.translate.api.TranslateService;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author samareshb915
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/translate",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Transalte.Rest",
		"liferay.auth.verifier=false",
		"liferay.oauth2=false"
	},
	service = Application.class
)
public class RestApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	/*
	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}
	*/
	
	@GET
	@Path("/{from}/{to}")
	@Produces("text/plain")
	public String translate(
		@PathParam("from") String from,
		@PathParam("to") String to,
		@QueryParam("html") String html) {

		return _translateService.doTranslate(from,to,html);
	}
	
	@Reference(cardinality= ReferenceCardinality.MANDATORY)
	protected TranslateService _translateService;

}