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
                                    <label for="exampleInput">Título</label>
                                    <input type="text" class="form-control" placeholder="Título">
                                </div>
                            </div>
                            <div class="col-md-3 px-md-1">
                                <div class="form-group">
                                    <label for="exampleInput">Autor</label>
                                    <input type="text" class="form-control" placeholder="Autor">
                                </div>
                            </div>
                            <div class="col-md-4 pl-md-1">
                                <div class="form-group">
                                    <label for="exampleInput">Fuente</label>
                                    <input type="text" class="form-control" placeholder="Fuente de la noticia...">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 pr-md-1">
                                <div class="form-group">
                                    <label for="exampleInput">URL</label>
                                    <input type="text" class="form-control" placeholder="URL...">
                                </div>
                            </div>
                            <div class="col-md-6 pl-md-1">
                                <div class="form-group">
                                    <label for="exampleInput">URL de la imagen</label>
                                    <input type="text" class="form-control" placeholder="URL de la imagen...">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8">
                                <div class="form-group">
                                    <label>Descripción</label>
                                    <textarea rows="4" cols="80" class="form-control"
                                              placeholder="Descripción de la noticia..."></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8">
                                <div class="form-group">
                                    <label>Contenido</label>
                                    <textarea rows="4" cols="80" class="form-control"
                                              placeholder="Contenido de la noticia..."></textarea>
                                </div>
                            </div>
                        </div>
                        <!--TODO: modificar fecha de publicación del sistema o de la noticia -->
                        <div class="row">
                            <div class="col-md-5 pr-md-1">
                                <div class="form-group">
                                    <label for="exampleInput">Fecha publicación</label>
                                    <input type="text" class="form-control" placeholder="Fecha...">
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
