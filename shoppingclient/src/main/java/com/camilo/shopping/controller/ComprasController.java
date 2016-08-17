package com.camilo.shopping.controller;

import java.net.URI;
import java.util.Collection;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkDiscoverer;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.hal.HalLinkDiscoverer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.camilo.shopping.model.Compra;

@Controller
@RequestMapping("/compras")
public class ComprasController {

	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("compras");
		
//		Traverson traverson = new Traverson(URI.create("http://localhost:9000"), MediaTypes.HAL_JSON);
//		Collection<Compra> compras = traverson.follow("compras", "search", "ordena-valor-ascendente").toObject(new ParameterizedTypeReference<Resources<Compra>>(){}).getContent();		
//		mv.addObject("compras", compras);
		
		Traverson traverson = new Traverson(URI.create("http://localhost:9000"), MediaTypes.HAL_JSON);
		List<Link> links = traverson.follow()
				.toObject(new ParameterizedTypeReference<Resources<Compra>>(){}).getLinks();		
		mv.addObject("links", links);

		return mv;
	}
}
