package com.uicheon.ytsocialapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform