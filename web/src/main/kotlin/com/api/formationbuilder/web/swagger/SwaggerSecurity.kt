package com.api.formationbuilder.web.swagger

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement

@Operation(security = [SecurityRequirement(name = "bearerAuth")])
annotation class SwaggerSecurity()
