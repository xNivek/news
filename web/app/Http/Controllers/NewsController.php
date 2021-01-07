<?php

namespace App\Http\Controllers;

use App\Models\News;
use Illuminate\Http\Request;

class NewsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        // SELECT * FROM News
        $news = News::all();

        return response([
            'message' => 'Retrieve Successfully',
            'news' => $news
        ], 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {

        $news = new News();
        $news ->save($request);

        /**
        $news->title = $request->title;
        $news->author = $request->author;
        $news->source = $request->source;
        $news->url = $request->url;
        $news->url_image = $request->url_image;
        $news->description = $request->description;
        $news->content = $request->content;
        $news->published_at = $request->published_at;
        */

    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $news= News::findOrFail($id);
        return new NewsResource($news);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $news = News::findOrFail($id);
        $news ->save($request);
        /**
        $news->title = $request->title;
        $news->author = $request->author;
        $news->source = $request->source;
        $news->url = $request->url;
        $news->url_image = $request->url_image;
        $news->description = $request->description;
        $news->content = $request->content;
        $news->published_at = $request->published_at;
        */
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $news = News::findOrFail($id);
        if($news->delete()){
            return new NewsResource($news);
        }
    }
}
