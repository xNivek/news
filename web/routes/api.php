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

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});
route::get('/news',[NewsController::class,'apires']);
//CRUD Routes
//Route::Resource('news', NewsController::class);

Route::get('/news',[NewsController::class,'index']);

Route::post('/news',[NewsController::class,'store']);

Route::get('/news/{id}',[NewsController::class,'show']);

//Route::post('/news',[NewsController::class,'create']);

Route::put('/news/{id}',[NewsController::class,'update']);

Route::put('/news/{id}',[NewsController::class,'destroy']);

//Autentication Route
Route::post('/register',[AuthController::class,'register']);

Route::post('/login',[AuthController::class,'login']);

Route::group(['middleware' => ['auth:sanctum']], function(){

});

Route::get('searcht/{title}',[NewsController::class, 'searcht']);

Route::get('searchc/{contenido}',[NewsController::class, 'searchc']);
