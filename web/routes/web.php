<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\NewsController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

//Default route
Route::get('/', function () {
    return view('welcome');
});

//Route to principal index
Route::get("/news",[NewsController::class, "noticias"])->name('news.index');

//Route to create
Route::get('/news/create', function () {
    return view('news.create');
});

//Route to store, save news api
Route::post('/news', [NewsController::class, 'store'])->name('news.store');

//Route to destroy, delete news
Route::get('/news/destroy/{id}', [NewsController::class, 'destroy'])->name('news.destroy');;
