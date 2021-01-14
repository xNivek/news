@extends('layouts.app')

@section('content')
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h5 class="title">Agregar noticia</h5>
                </div>
                <div class="card-body">
                    <form action="{{ route('news.store') }}" method="post">
                        @csrf
                        <div class="row">
                            <div class="col-md-5 pr-md-1">
                                <div class="form-group">
                                    <label for="title">Título</label>
                                    <input id="title" name="title" type="text" class="form-control" placeholder="Título">
                                </div>
                            </div>
                            <div class="col-md-3 px-md-1">
                                <div class="form-group">
                                    <label for="author">Autor</label>
                                    <input id="author" name="author" type="text" class="form-control" placeholder="Autor">
                                </div>
                            </div>
                            <div class="col-md-4 pl-md-1">
                                <div class="form-group">
                                    <label for="source">Fuente</label>
                                    <input id="source" name="source" type="text" class="form-control" placeholder="Fuente de la noticia...">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 pr-md-1">
                                <div class="form-group">
                                    <label for="url">URL</label>
                                    <input id="url" name="url" type="text" class="form-control" placeholder="URL...">
                                </div>
                            </div>
                            <div class="col-md-6 pl-md-1">
                                <div class="form-group">
                                    <label for="url_image">URL de la imagen</label>
                                    <input id="url_image" name="url_image" type="text" class="form-control" placeholder="URL de la imagen...">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8">
                                <div class="form-group">
                                    <label>Descripción</label>
                                    <textarea id="description" name="description" rows="4" cols="80" class="form-control"
                                              placeholder="Descripción de la noticia..."></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8">
                                <div class="form-group">
                                    <label>Contenido</label>
                                    <textarea id="contenido" name="contenido" rows="4" cols="80" class="form-control"
                                              placeholder="Contenido de la noticia..."></textarea>
                                </div>
                            </div>
                        </div>
                        <!--TODO: modificar fecha de publicación del sistema o de la noticia -->
                        <div class="row">
                            <div class="col-md-5 pr-md-1">
                                <div class="form-group">
                                    <label for="published_at">Fecha publicación</label>
                                    <input id="published_at" name="published_at" type="text" class="form-control" placeholder="Fecha..." value="{{date("Y-m-d H:i:s")}}" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer">
                            <button type="submit" class="btn btn-fill btn-primary">Guardar</button>
                        </div>
                    </form>

                </div>

            </div>
        </div>

    </div>
@endsection
