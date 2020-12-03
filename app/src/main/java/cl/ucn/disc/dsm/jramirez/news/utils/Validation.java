/*
 * Copyright 2020 Jean Ramirez Castillo jean.ramirez@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.jramirez.news.utils;

/**
 * The Validation class.
 *
 * @author Jean Ramirez-Castillo.
 */
public final class Validation {

    /**
     *
     * @param value to check
     * @param minSize to fail
     * @param message to throw in case of wrong size.
     */
    public static void minSize(String value, int minSize, String message) {
        notNull(value, message);
        if(value.length() < minSize){
            throw new IllegalArgumentException("Argument null or wrong size -->");
        }
    }

    /**
     * Check nullity
     *
     * @param o object to test
     * @param message to throw in case of null
     */
    public static void notNull(Object o, String message) {
        if(o == null){
            throw new IllegalArgumentException("Argument was null -->" + message);
        }
    }
}
