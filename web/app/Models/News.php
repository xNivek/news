<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class News extends Model
{
    use HasFactory;

    //TODO:revisar o eliminar
    protected $table = "news";

    protected $fillable = ['title','author','source','url','url_image','description','contenido','published_at'];
}
