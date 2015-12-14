package service;

import java.util.List;

import model.Ordenador;

public interface OrdenadorService {
	void agregarOrdenador(Ordenador o);
	void modificarOrdenador(Ordenador o);
	void eliminarOrdenador(Integer id);
	Ordenador obtenerOrdenador(Integer id);
	List<Ordenador> obtenerOrdenadores();
}
