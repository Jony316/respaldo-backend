from rest_framework import viewsets

from api.models import Estudiante, TipoEstudiante
from api.serializers import EstudianteSerializer, TipoEstudianteSerializer

from rest_framework.decorators import action
from rest_framework.request import Request
from rest_framework.response import Response
import requests

class TipoEstudianteViewSet ( viewsets.ModelViewSet ):
    serializer_class = TipoEstudianteSerializer
    queryset = TipoEstudiante.objects.all()

class EstudianteViewSet ( viewsets.ModelViewSet ):
    serializer_class = EstudianteSerializer
    queryset = Estudiante.objects.all()
    
    @action(detail=True, methods=['patch'])
    def completardatos(self, request: Request, *args, **kwargs):
        id= kwargs['pk']
        estudiante = Estudiante.objects.get(pk=id)
        response = requests.get("https://jsonplaceholder.typicode.com/users/"+id)
        if response.status_code == 200:
            data = response.json()
            estudiante.email = data['email']
            estudiante.phone = data['phone']
            estudiante.save()
            serializer = EstudianteSerializer(estudiante)
            return Response(serializer.data, content_type="application/json")
        else:
            return Response("Error en la consulta a la API externa", status=500)
