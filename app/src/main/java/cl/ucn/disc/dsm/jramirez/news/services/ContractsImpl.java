/*
 * Copyright 2020 Jean Ramirez Castillo jean.ramirez@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.jramirez.news.services;

import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dsm.jramirez.news.model.News;

/**
 * @author Jean Ramirez-Castillo.
 */
public class ContractsImpl implements Contracts {
    /**
     * Get the list of News.
     *
     * @param size size of the list.
     * @return the list of News.
     */
    @Override
    public List<News> retrieveNews(Integer size) {

        // The list of news
        final List<News> news = new ArrayList<>();

        // TODO: Add the faker news to the list


        return news;
    }

    /**
     * Save one News into the System
     *
     * @param news to save.
     */
    @Override
    public void saveNews(News news) {

    }
}
