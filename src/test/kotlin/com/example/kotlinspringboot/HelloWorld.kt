package com.example.kotlinspringboot

import kotlinx.coroutines.*
import org.springframework.web.client.RestTemplate
import javax.xml.bind.JAXBElement


//fun main() {
////    var r = rest.getForObject("http://search-b.11stcorp.com/kr11st/1.0/search/goods?q=%EC%83%9D%EC%88%98&client_code=health_check&ccs_refresh=yes", String.javaClass)
//
//    val restTemplate = RestTemplate()
//
//    val time = System.currentTimeMillis()
//    for (i in 0..99) {
//        val s1 = restTemplate.getForObject(
//            "http://search-i.11stcorp.com/kr11st/1.0/search/goods?q=%EC%83%9D%EC%88%98&client_code=health_check&ccs_refresh=yes",
//            String::class.java
//        )
//    }
//    println(System.currentTimeMillis() - time)
//}

suspend fun main() {
    println("Start Main Thread")


    val li = ArrayList<Deferred<Unit>>()
    for (i in 0..99) {
        li.add(doF())
    }
    val time = System.currentTimeMillis()
    li.awaitAll()
    println("End Main Thread")
    println(System.currentTimeMillis() - time)
}

fun doF(): Deferred<Unit> {
    var r = GlobalScope.async {
        //    for (i in 0..99) {
        val restTemplate = RestTemplate()
        val s1 = restTemplate.getForObject(
            "http://search-i.11stcorp.com/kr11st/1.0/search/goods?q=%EC%83%9D%EC%88%98&client_code=health_check&ccs_refresh=yes",
            String::class.java
        )
//    }
    }
    return r
}

