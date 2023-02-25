package com.manubett.news.data.dto

import com.manubett.news.domain.model.NewsItem

data class NewsDto(
    val response: Response
)

fun NewsDto.toNewsItem(): List<NewsItem> {
    val results = response.results
    return results.map { result ->

        val day = result.webPublicationDate.slice(8..9)
        val month = result.webPublicationDate.slice(5..6)
        val year = result.webPublicationDate.slice(0..3)

        val productionDate = "$day-$month-$year"


        val modifiedDay = result.fields.lastModified.slice(8..9)
        val modifiedMonth = result.fields.lastModified.slice(5..6)
        val modifiedYear = result.fields.lastModified.slice(0..3)

        val modificationDate = "$modifiedDay-$modifiedMonth-$modifiedYear"

        val productionOffice = result.fields.productionOffice

        val sourcePublication  = result.fields.publication

        NewsItem(
            image = result.fields.thumbnail,
            title = result.webTitle,
            headline = result.fields.headline,
            time =  "$productionDate:${result.webPublicationDate.slice(11..15)}",
            author = if (result.tags.isNotEmpty()) result.tags[0].firstName else "Guardians",//"by ${result.tags?.map { it.firstName}}",
            ratings = result.fields.starRating,
            sourcePublication = sourcePublication,
            authorsImage = if (result.tags.isNotEmpty()) result.tags[0].bylineImageUrl else null,//result.fields.thumbnail,//" ${result.tags?.map { it.bylineImageUrl}} ",
            sectionName = result.sectionName,
            bodyText = result.fields.bodyText,
            trailText = result.fields.trailText,
            body = result.fields.body,
            id = result.id,
            productionOffice = productionOffice.ifEmpty { sourcePublication },
            lastModified = modificationDate.ifEmpty { productionDate },
        )
    }
}