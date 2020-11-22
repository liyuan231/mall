package com.liyuan.component.security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;

public class JsonUsernamePasswordAuthenticationFilter extends GenericFilterBean {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try (ServletInputStream inputStream = request.getInputStream()) {
            JsonNode jsonNode = objectMapper.readTree(inputStream);
            JsonNode username = jsonNode.get("username");
            if (username != null) {
                request.setAttribute("username", username.asText());
            }
            JsonNode password = jsonNode.get("password");
            if (password != null) {
                request.setAttribute("password", password.asText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        chain.doFilter(request, response);
    }
}
