package com.manubett.news.feature_posts.domain.model

data class NewsItem(
    val tagId : List<String>?,
    val resultId : String?,
    val twitterHandle: List<String>?,
    val image: String? = null,
    val title:  String? = null,
    val headline:  String? = null,
    val time: String? = null,
    val author:  List<String>? = emptyList(),
    val ratings:  String? = null,
    val sourcePublication: String? = null,
    val authorsImage: List<String>? = null,//List<String>? = emptyList(), //checkOn
    val sectionName: String? = null,
    val bodyText: String? = null,
    val trailText: String? = null,
    val body: String? = null,
    val bio: List<String>,
    val productionOffice: String? = null,
    val lastModified: String? = null,
    val fullNames: String?,
    val id : String?
)
