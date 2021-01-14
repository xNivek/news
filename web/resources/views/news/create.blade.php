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
                                    <input id="title" name="title" type="text" class = "form-control" placeholder="Título" value="{{ old('title') }}">

                                    @error('title')
                                        <div class="alert alert-danger">Campo requerido...</div>
                                    @enderror
                                </div>
                            </div>
                            <div class="col-md-3 px-md-1">
                                <div class="form-group">
                                    <label for="author">Autor</label>
                                    <input id="author" name="author" type="text" class="form-control" placeholder="Autor..." value="{{ old('author') }}">

                                    @error('author')
                                    <div class="alert alert-danger">Campo requerido...</div>
                                    @enderror
                                </div>
                            </div>
                            <div class="col-md-4 pl-md-1">
                                <div class="form-group">
                                    <label for="source">Fuente</label>
                                    <input id="source" name="source" type="text" class="form-control" placeholder="Fuente de la noticia..."
                                           value="{{ old('source') }}">

                                    @error('source')
                                    <div class="alert alert-danger">Campo requerido...</div>
                                    @enderror
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 pr-md-1">
                                <div class="form-group">
                                    <label for="url">URL</label>
                                    <input id="url" name="url" type="text" class="form-control" placeholder="URL..."
                                           value="{{ old('url') }}">

                                    @error('url')
                                    <div class="alert alert-danger">Campo requerido...</div>
                                    @enderror
                                </div>
                            </div>
                            <div class="col-md-6 pl-md-1">
                                <div class="form-group">
                                    <label for="url_image">URL de la imagen</label>
                                    <input id="url_image" name="url_image" type="text" class="form-control" placeholder="URL de la imagen..."
                                           value="{{ old('url_image') }}">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8">
                                <div class="form-group">
                                    <label>Descripción</label>
                                    <textarea id="description" name="description" rows="4" cols="80" class="form-control"
                                              placeholder="Descripción de la noticia...">{{ old('description') }}</textarea>

                                    @error('description')
                                    <div class="alert alert-danger">Ingrese descripción de la noticia.</div>
                                    @enderror
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8">
                                <div class="form-group">
                                    <label>Contenido</label>
                                    <textarea id="contenido" name="contenido" rows="4" cols="80" class="form-control"
                                              placeholder="Contenido de la noticia...">{{ old('contenido') }}</textarea>

                                    @error('contenido')
                                    <div class="alert alert-danger">Ingrese contenido de la noticia.</div>
                                    @enderror
                                </div>
                            </div>
                        </div>
                        <!--TODO: modificar fecha de publicación del sistema o de la noticia -->
                        <div class="row">
                            <div class="col-md-5 pr-md-1">
                                <div class="form-group">
                                    <label for="published_at">Fecha publicación</label>
                                    <input id="published_at" name="published_at" type="text" class="form-control"
                                           placeholder="Fecha..." value="{{date("Y-m-d H:i:s")}}" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer">
                            <button type="submit" class="btn btn-fill btn-primary">Publicar</button>
                        </div>
                    </form>

                </div>

            </div>
        </div>

    </div>
@endsection
