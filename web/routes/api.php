<?php

use App\Http\Controllers\AuthController;
use App\Http\Controllers\NewsController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

//Default route
Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});

//Route retro fit
route::get('/news/apirres/',[NewsController::class,'apires']);

//CRUD Routes
Route::Resource('news', NewsController::class);

//Search Route for title
Route::get('searcht/{title}',[NewsController::class, 'searcht']);

//Search Rout for content
Route::get('searchc/{contenido}',[NewsController::class, 'searchc']);
