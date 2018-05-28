package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Location;
import com.eci.cosw.springbootsecureapi.model.Todo;
import com.eci.cosw.springbootsecureapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 10/31/17.
 */
@RestController
@RequestMapping( "api" )
public class TodoController
{

    @Autowired
    private TodoService todoService;


    @RequestMapping( value = "/todo", method = RequestMethod.POST )
    public void addTodo( @RequestBody Todo todo )
        throws ServletException
    {
        todoService.addTodo( todo );
    }

    @RequestMapping( value = "/todo", method = RequestMethod.GET )
    public List<Todo> getTodoList()
        throws ServletException
    {
        return todoService.getTodoList();
    }

    
    @RequestMapping( value = "/location", method = RequestMethod.POST )
    public void addLocation( @RequestBody Location location)
        throws ServletException
    {
        System.err.println("Longitud Recibida: "+location.getLongitud());
        System.err.println("Latitud Recibida: "+location.getLatitud());
    }

}
