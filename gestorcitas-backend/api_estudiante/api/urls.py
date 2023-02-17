from rest_framework.routers import DefaultRouter
from api.views import EstudianteViewSet, TipoEstudianteViewSet

router = DefaultRouter()

router.register('api/estudiante', EstudianteViewSet)
router.register('api/tipoestudiante', TipoEstudianteViewSet)

urlpatterns = []

urlpatterns += router.urls
