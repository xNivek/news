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

import net.openhft.hashing.LongHashFunction;

import org.threeten.bp.ZonedDateTime;

import cl.ucn.disc.dsm.jramirez.news.utils.Validation;

/**
 *  The Domain model: News.
 *
 * @author Jean Ramirez-Castillo
 */
public final class News {

    /**
     * Unique id
     */
    private final Long id;

    /**
     * The Title
     * Restriction: not null, size > 2
     */
    private final String title;

    /**
     * The Source
     */
    private final String source;

    /**
     * The Author.
     */
    private final String author;

    /**
     * The URL.
     */
    private final String url;

    /**
     * The URL of image.
     */
    private final String urlImage;

    /**
     * The Description.
     */
    private final String description;

    /**
     * The Content.
     */
    private final String content;

    /**
     * The Date of publish
     */
    private final ZonedDateTime publishedAt;

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
        return this.id;
    }

    /**
     * @return the title.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return the source.
     */
    public String getSource() {
        return this.source;
    }

    /**
     * @return the author.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * @return the url.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * @return the url of image.
     */
    public String getUrlImage() {
        return this.urlImage;
    }

    /**
     * @return the description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return the content.
     */
    public String getContent() {
        return this.content;
    }

    /**
     * @return the published at
     */
    public ZonedDateTime getPublishedAt() {
        return this.publishedAt;
    }

    // TODO: Remove after testing
    @NonNull
    @Override
    public String toString() {
        return this.title;
    }
}
