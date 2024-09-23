package uz.ifood.app.v1.utils

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.OncePerRequestFilter
import uz.ifood.app.v1.services.UserDetailsServiceImpl
import java.io.IOException

class JwtAuthTokenFilter : OncePerRequestFilter() {

    @Autowired
    private val tokenProvider: JwtProvider? = null

    @Autowired
    private val userDetailsService: UserDetailsServiceImpl? = null

//    companion object {
//        private val logger = LoggerFactory.getLogger(JwtAuthTokenFilter::class.java)
//    }

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {

            val jwt = getJwt(request)
            if (jwt != null && tokenProvider!!.validateJwtToken(jwt)) {
                val username = tokenProvider.getUserNameFromJwtToken(jwt)

                val userDetails = userDetailsService!!.loadUserByUsername(username)
                val authentication = UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails?.getAuthorities())
                authentication.setDetails(WebAuthenticationDetailsSource().buildDetails(request))

                SecurityContextHolder.getContext().setAuthentication(authentication)
            }
        } catch (e: Exception) {
            logger.error("Can NOT set user authentication -> Message: {}", e)
        }

        filterChain.doFilter(request, response)
    }

    private fun getJwt(request: HttpServletRequest): String? {
        val authHeader = request.getHeader("Authorization")

        return if (authHeader != null && authHeader.startsWith("Bearer ")) {
            authHeader.replace("Bearer ", "")
        } else null
    }


}
