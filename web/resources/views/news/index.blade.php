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
                    <a href="/news/create" class="btn btn-sm btn-success">Añadir</a>
                    <div class="table-responsive">
                        <table class="table table-striped" id="myTable">
                            <thead class=" text-primary">
                            <tr>
                                <th>
                                    Título
                                </th>
                                <th>
                                    Autor
                                </th>
                                <th>
                                    Fuente
                                </th>
                                <th>
                                    url
                                </th>
                                <th>
                                    url_imagen
                                </th>
                                <th>
                                    Descripción
                                </th>
                                <th>
                                    Contenido
                                </th>
                                <th>
                                    Publicado en
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
                                    <td>{{$item->url_image}}</td>
                                    <td>{{$item->description}}</td>
                                    <td>{{$item->contenido}}</td>
                                    <td>{{$item->published_at}}</td>

                                    <td style="width:210px">
                                        <a href="" class="btn btn-sm btn-primary">Edit</a>
                                        <a href="{{ route('news.destroy', $item->id) }}" class="btn btn-sm btn-danger">Delete</a>
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
    <script>
        $(document).ready(function () {
            var table = $('#myTable').DataTable({
                "language": {
                    "lengthMenu": "Mostrar _MENU_ por página",
                    "zeroRecords": "No se encontraron datos",
                    "info": "Mostrando página PAGE de PAGES",
                    "infoEmpty": "Sin datos disponibles",
                    "infoFiltered": "(Filtro desde MAX total datos)",
                    "search": "Buscar",
                    "decimal": ",",
                    "thousands": "."
                },
                "order": [[ 7, "desc" ]]
            });
        });
    </script>
@endsection
