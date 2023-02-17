from rest_framework import serializers
from api.models import Estudiante, TipoEstudiante

class EstudianteSerializer (serializers.ModelSerializer):
    class Meta:
        model = Estudiante
        fields = "__all__"
        
class TipoEstudianteSerializer (serializers.ModelSerializer):
    class Meta:
        model = TipoEstudiante
        fields = "__all__"