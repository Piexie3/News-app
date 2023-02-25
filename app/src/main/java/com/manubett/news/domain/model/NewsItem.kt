package com.manubett.news.domain.model

import com.manubett.news.R
data class NewsItem(
    val image: String? = null,
    val imageInt: Int? = R.drawable.placeholder,
    val title:  String? = null,
    val headline:  String? = null,
    val time: String? = null,
    val author:  String? = null,
    val ratings:  String? = null,
    val sourcePublication: String? = null,
    val authorsImage: String? = null,//List<String>? = emptyList(), //checkOn
    val sectionName: String? = null,
    val bodyText: String? = null,
    val trailText: String? = null,
    val body: String? = null,
    val productionOffice: String? = null,
    val lastModified: String? = null,
    val id : String? = null
)
