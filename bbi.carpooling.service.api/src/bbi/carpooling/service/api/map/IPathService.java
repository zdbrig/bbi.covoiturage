package bbi.carpooling.service.api.map;

import java.util.List;

import bbi.carpooling.model.map.Path;
import bbi.carpooling.model.user.CPUser;

public interface IPathService {

	// Path Functions
	Path createPath(CPUser cpUser);

	List<Path> getUserPaths(CPUser cpUser);

	Path savePath(Path path);

	Path getPath(Long id);

	Path duplicatePath(Path fromPath);

	Path cancelPath(Path Path);

	void deletePath(Path path);

}
