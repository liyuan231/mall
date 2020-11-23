package com.liyuan.component.security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JsonUsernamePasswordAuthenticationFilter extends
        UsernamePasswordAuthenticationFilter {
    private ObjectMapper objectMapper = new ObjectMapper();
    private Logger logger = LoggerFactory.getLogger(getClass());

    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE) || request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;

            try (ServletInputStream inputStream = request.getInputStream()) {
                String username = "";
                String password = "";
                JsonNode jsonNode = objectMapper.readTree(inputStream);
                JsonNode username_ = jsonNode.get("username");
                if (username_ != null) {
                    username = username_.asText();
                }
                JsonNode password_ = jsonNode.get("password");
                if (password_ != null) {
                    password = password_.asText();
                }
                usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            } catch (IOException e) {
                logger.error("json解析登录时数据错误！");
                usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken("", "");
            } finally {
                assert usernamePasswordAuthenticationToken != null;
                usernamePasswordAuthenticationToken.setDetails(authenticationDetailsSource.buildDetails(request));
                return this.getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
            }
        } else {
            return super.attemptAuthentication(request, response);
        }
    }
}
