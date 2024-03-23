package hs.kr.equus.user.domain.admin.exception

import hs.kr.equus.user.global.error.exception.EquusException
import hs.kr.equus.user.global.error.exception.ErrorCode

object AdminUnauthorizedException : EquusException(
    ErrorCode.ADMIN_UNAUTHORIZED
)
