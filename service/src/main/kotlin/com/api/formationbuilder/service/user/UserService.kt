package com.api.formationbuilder.service.user

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Service


@Service
open class UserService {

    fun getUserId(): String {
        return getClaim("sub") as String
    }


    private fun getClaim(claim: String): Any? {
        return jwtAuthentication().claims[claim]
    }

    private fun jwtAuthentication(): Jwt {
        return SecurityContextHolder.getContext().authentication.principal as Jwt
    }

}