from django.db import models

class TipoEstudiante (models.Model):
    tipo = models.CharField(max_length=80)

class Estudiante (models.Model):
    nombre = models.CharField(max_length=80)
    cedula = models.IntegerField()
    carrera = models.CharField(max_length=80)
    curso = models.CharField(max_length=80)
    fecha = models.DateField(auto_now=False, auto_now_add=False)
    tipo = models.ForeignKey(TipoEstudiante, on_delete=models.PROTECT)
    email = models.CharField(max_length=80)
    phone = models.CharField(max_length=80)

# Create your models here.
