package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.OrdenadorDao;
import model.Ordenador;

@Service
@Transactional
public class OrdenadorServiceImpl implements OrdenadorService {
	@Autowired
	private OrdenadorDao ordenadorDao;
	
	@Override
	public void agregarOrdenador(Ordenador o) {
		ordenadorDao.agregar(o);
	}

	@Override
	public void modificarOrdenador(Ordenador o) {
		ordenadorDao.modificar(o);
	}

	@Override
	public void eliminarOrdenador(Integer id) {
		ordenadorDao.eliminar(id);
	}

	@Override
	public Ordenador obtenerOrdenador(Integer id) {
		return ordenadorDao.obtener(id);
	}

	@Override
	public List<Ordenador> obtenerOrdenadores() {
		return ordenadorDao.obtenerTodos();
	}

}
