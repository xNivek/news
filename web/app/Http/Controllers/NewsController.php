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
        //paginate json
        $newsList= News::paginate(10);
        return response() ->json( $newsList,200);

    }

    /**
     * Display a listing of the clean resource.
     *
     * @return mixed
     */
    public function apires()
    {
        $news = News::all();
        return $news;

    }

    /**
     * Index app Web
     *
     * @return \Illuminate\Contracts\Foundation\Application|\Illuminate\Contracts\View\Factory|\Illuminate\Contracts\View\View
     */
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
       //
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

    /**
     * Search for title
     *
     * @param $title
     * @return \Illuminate\Http\JsonResponse
     */
    public function searcht($title)
    {
        $news = News::where('title','like',"%{$title}%")->get();
        return response()->json(['title' => $news]);

    }

    /**
     * Search for content
     *
     * @param $contenido
     * @return \Illuminate\Http\JsonResponse
     */
    public function searchc($contenido)
    {
        $news = News::where('contenido','like',"%{$contenido}%")->get();
        return response()->json(['contenido' => $news]);

    }
}
