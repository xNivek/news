@extends('layouts.app')

<!--Hereda código de app.blade-->
@section('content')

    <div class="row">
        <div class="col-md-12">
            <div class="card ">
                <div class="card-header">
                    <h4 class="card-title"> Simple Table</h4>
                </div>
                <div class="card-body">
                    <a href="/news/create" class="btn btn-sm btn-success">ADD</a>
                    <div class="table-responsive">
                        <table class="table tablesorter " id="">
                            <thead class=" text-primary">
                            <tr>
                                <th>
                                    title
                                </th>
                                <th>
                                    author
                                </th>
                                <th>
                                    source
                                </th>
                                <th>
                                    url
                                </th>
                                <th>
                                    description
                                </th>
                                <th>
                                    content
                                </th>
                                <th>
                                    published_at
                                </th>
                                <th >
                                    Action
                                </th>

                                <!-- <th class="text-center"> esto es para centrar el texto
                                    Salary
                                </th>  -->
                            </tr>
                            </thead>
                            <tbody>

                            @foreach($news as $item)
                                <tr>
                                    <td>{{$item->title}}</td>
                                    <td>{{$item->author}}</td>
                                    <td>{{$item->source}}</td>
                                    <td>{{$item->url}}</td>
                                    <td>{{$item->description}}</td>
                                    <td>{{$item->contenido}}</td>
                                    <td>{{$item->published_at}}</td>

                                    <td style="width:210px">
                                        <a href="" class="btn btn-sm btn-primary">Edit</a>
                                        <a href="" class="btn btn-sm btn-danger">Delete</a>
                                    </td>
                                </tr>
                            @endforeach

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
