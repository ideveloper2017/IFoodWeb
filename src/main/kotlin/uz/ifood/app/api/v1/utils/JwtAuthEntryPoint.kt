package uz.ifood.app.api.v1.utils

import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.io.IOException


@Component
class JwtAuthEntryPoint: AuthenticationEntryPoint {

    @Throws(IOException::class, ServletException::class)
    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        e: AuthenticationException?
    ) {
        logger.error("Unauthorized error. Message - {}", e!!.message)
        response?.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(uz.ifood.app.api.v1.utils.JwtAuthEntryPoint::class.java)
    }
}
