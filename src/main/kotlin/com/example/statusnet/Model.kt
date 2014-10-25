package com.example.statusnet

/**
 * Created by evacchi on 10/10/14.
 */
data class Post(val id: Long, val text: String, val user: User)
data class User(val id: Long, val name: String, val screen_name: String)
