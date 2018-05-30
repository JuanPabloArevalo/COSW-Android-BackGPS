package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Date;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@RestController
@RequestMapping( "gpsApi/v1/users" )
public class UserController
{

    @Autowired
    private UserService userService;

    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login( @RequestBody User login )
        throws ServletException
    {

        String jwtToken = "";

        if ( login.getDocument() == null || login.getPhoneNumber() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String identificacion = login.getDocument();
        String phoneNumber = login.getPhoneNumber();
        System.err.println("Identificación: "+identificacion);
        User user = userService.findUserByIdentification( identificacion );

        if ( user == null )
        {
            throw new ServletException( "User username not found." );
        }

        String pwd = user.getPhoneNumber();
        System.err.println("Phone: "+pwd);
        if ( !phoneNumber.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }

        jwtToken = Jwts.builder().setSubject( identificacion ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
            io.jsonwebtoken.SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    public class Token
    {

        String access_token;


        public Token( String access_token )
        {
            this.access_token = access_token;
        }


        public String getAccessToken()
        {
            return access_token;
        }

        public void setAccessToken( String access_token )
        {
            this.access_token = access_token;
        }
    }

}
