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

        $newsList= News::paginate(2);
        return response() ->json( $newsList,200);


        /**return response([
            'message' => 'Retrieve Successfully',
            'news' => $newsS
        ], 200);
         */
    }

    public function noticias()
    {
        // SELECT * FROM News
        $news = News::all();

        return view('news.index', compact('news'));


    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('news.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {


        $validated = $request->validate([
            'title' => 'required|max:255',
            'author' => 'required|max:50',
            'source' => 'required',
            'url' => 'required|max:255',
            'url_image' => 'nullable|max:255',
            'description' => 'required|max:255',
            'contenido' => 'required|max:255',
            'published_at' => 'required|max:255',
        ]);



        News::create($request->all());

        return redirect()->route('news.index');

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

        /**
        $news->title = $request->title;
        $news->author = $request->author;
        $news->source = $request->source;
        $news->url = $request->url;
        $news->url_image = $request->url_image;
        $news->description = $request->description;
        $news->contenido = $request->contenido;
        $news->published_at = $request->published_at;

        if($news->save()){
            return new NewsResource();
        }
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
        $news->delete();
        return redirect()->route('news.index');
    }
}
