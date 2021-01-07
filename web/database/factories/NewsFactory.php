<?php

namespace Database\Factories;

use App\Models\News;
use Illuminate\Database\Eloquent\Factories\Factory;

class NewsFactory extends Factory
{
    /**
     * The name of the factory's corresponding model.
     *
     * @var string
     */
    protected $model = News::class;

    /**
     * Define the model's default state.
     *
     * @return array
     */
    public function definition()
    {
        return [

            'title' => $this->faker->text(20),
            'author' => $this->faker->name,
            'source' => $this->faker->text(30),
            'url' => $this->faker->url,
            'url_image' => $this->faker->imageUrl(640,480,null,true,null,false),
            'description' => $this->faker->text(100),
            'contenido' => $this->faker->text(40),
            'published_at' => $this->faker->dateTime,


        ];
    }
}
