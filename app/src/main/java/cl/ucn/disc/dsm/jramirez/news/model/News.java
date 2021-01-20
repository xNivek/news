/*
 * Copyright 2020 Jean Ramirez Castillo jean.ramirez@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.jramirez.news.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import net.openhft.hashing.LongHashFunction;

import org.threeten.bp.ZonedDateTime;

import cl.ucn.disc.dsm.jramirez.news.utils.Validation;

/**
 *  The Domain model: News.
 *
 * @author Jean Ramirez-Castillo
 */
@Entity(tableName ="news_table")
public final class News {

    /**
     * Unique id
     */
    @PrimaryKey(autoGenerate =  false)
    public Long id;

    /**
     * The Title
     * Restriction: not null, size > 2
     */
    @ColumnInfo(name = "title")
    private final String title;

    /**
     * The Source
     */
    @ColumnInfo(name = "source")
    private final String source;

    /**
     * The Author.
     */
    @ColumnInfo(name = "author")
    private final String author;

    /**
     * The URL.
     */
    @ColumnInfo(name = "url")
    private final String url;

    /**
     * The URL of image.
     */
    @ColumnInfo(name = "urlImage")
    private final String urlImage;

    /**
     * The Description.
     */
    @ColumnInfo(name = "description")
    private final String description;

    /**
     * The Content.
     */
    @ColumnInfo(name = "content")
    private final String content;

    /**
     * The Date of publish
     */
    @ColumnInfo(name = "publishedAt")
    public ZonedDateTime publishedAt;

    /**
     * The Constructor.
     * @param title
     * @param source
     * @param author
     * @param url
     * @param urlImage
     * @param description
     * @param content
     * @param publishedAt
     */

    public News(String title, String source, String author, String url, String urlImage, String description, String content, ZonedDateTime publishedAt) {

        //validation title
        Validation.minSize(title, 2,  "title");
        this.title = title;

        // Validation source
        Validation.minSize(source, 2, "source");
        this.source = source;

        // Validation author
        Validation.minSize(author, 3, "author");
        this.author = author;

        // Hashing unique!
        this.id = LongHashFunction.xx().hashChars(title + "|" + source + "|" + author);

        // Can't be null
        this.url = url;
        this.urlImage = urlImage;

        // Validation description
        Validation.minSize(description, 10, "description");
        this.description = description;

        // Validation content
        Validation.notNull(content, "content");
        this.content = content;

        // Validation publishedAt
        Validation.notNull(publishedAt, "publishedAt");
        this.publishedAt = publishedAt;
    }

    /**
     * @return the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the source.
     */
    public String getSource() {
        return source;
    }

    /**
     * @return the author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return the url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the url of image.
     */
    public String getUrlImage() {
        return urlImage;
    }

    /**
     * @return the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the content.
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the published at
     */
    public ZonedDateTime getPublishedAt() {
        return publishedAt;
    }

    /**
    // TODO: Remove after testing
    @NonNull
    @Override
    public String toString() {
        return this.title;
    }*/
}
