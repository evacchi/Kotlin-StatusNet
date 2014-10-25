package com.example.statusnet

import org.apache.http.client.methods.HttpGet
import java.net.URL
import java.net.URLConnection
import com.google.gson.Gson
import java.io.Reader
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.io.InputStream
import java.io.InputStreamReader

private val endPoint = "http://quitter.se/api/statuses/public_timeline.json"

fun pullStatuses(): Collection<Post> {
    val url = URL(endPoint)
    val conn: URLConnection = url.openConnection()
    val input: InputStream  = conn.getInputStream() !!
    return deserializePosts(input)

}

fun deserializePosts(input: InputStream): Collection<Post> {
    val gson = Gson()
    val typeToken = (object : TypeToken<Collection<Post>>() {});
    val postCollectionType: Type = typeToken.getType()
    val inputStreamReader = InputStreamReader(input)
    return gson.fromJson(inputStreamReader, postCollectionType)

}