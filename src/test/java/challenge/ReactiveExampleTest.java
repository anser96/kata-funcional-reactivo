package challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class ReactiveExampleTest {

    @InjectMocks
    ReactiveExample reactiveExample;


    @Test
    void sumaDePuntajes(){
           var suma = reactiveExample.sumaDePuntajes();
        StepVerifier.create(suma)
                .expectNext(260)
                .verifyComplete();
    }

    @Test
    void losNombresDeEstudianteConPuntajeMayorA() {
        var valor = reactiveExample.losNombresDeEstudianteConPuntajeMayorA(75);
        StepVerifier.create(valor)
                .expectNext("pedro")
                .verifyComplete();
    }

    @Test
    void mayorPuntajeDeEstudiante(){
        var mayor = reactiveExample.mayorPuntajeDeEstudiante();
        StepVerifier.create(mayor)
                .expectNextMatches(response -> response.getPuntaje().equals(80))
                .verifyComplete();
    }

    @Test
    void totalDeAsisntenciasDeEstudiantesComMayorPuntajeDe(){
        var mayor = reactiveExample.totalDeAsisntenciasDeEstudiantesConMayorPuntajeDe(75);
        StepVerifier.create(mayor)
                .expectNext(10)
                .verifyComplete();
    }

    @Test
    void elEstudianteTieneAsistenciasCorrectas(){
        var estudiante = new Estudiante("pedro", 80, List.of(5, 5, 4, 5, 5));
        var asistenciasCorrectas = reactiveExample.elEstudianteTieneAsistenciasCorrectas(estudiante);

        StepVerifier.create(asistenciasCorrectas)
                .expectNext(true)
                .verifyComplete();
    }

    @Test
    void promedioDePuntajesPorEstudiantes(){
        var promedio = reactiveExample.promedioDePuntajesPorEstudiantes();
        StepVerifier.create(promedio)
                .expectNext(52.0)
                .verifyComplete();
    }

    @Test
    void estudiantesAprovados(){
        var aprovados = reactiveExample.estudiantesAprovados();
        StepVerifier.create(aprovados)
                .expectNext("juan", "pedro")
                .verifyComplete();
    }


}