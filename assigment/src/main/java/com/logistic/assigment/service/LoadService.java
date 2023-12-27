package com.logistic.assigment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.assigment.repository.LoadRepository;
import com.logistic.assigment.model.Load;

import java.util.List;
import java.util.Optional;

@Service
public class LoadService {
    @Autowired
    private LoadRepository loadRepository;

    public Load createLoad(Load load) {
        return loadRepository.save(load);
    }

    public List<Load> getLoadsByShipperId(String shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public Optional<Load> getLoadById(Long loadId) {
        return loadRepository.findById(loadId);
    }

    public Load updateLoad(Long loadId, Load updatedLoad) {
        Optional<Load> existingLoad = loadRepository.findById(loadId);
        if (existingLoad.isPresent()) {
            Load loadToUpdate = existingLoad.get();
            // update fields
            loadToUpdate.setLoadingPoint(updatedLoad.getLoadingPoint());
            loadToUpdate.setUnloadingPoint(updatedLoad.getUnloadingPoint());
            loadToUpdate.setProductType(updatedLoad.getProductType());
            loadToUpdate.setTruckType(updatedLoad.getTruckType());
            loadToUpdate.setNoOfTruck(updatedLoad.getNoOfTruck());  // Corrected method name
            loadToUpdate.setWeight(updatedLoad.getWeight());
            loadToUpdate.setComment(updatedLoad.getComment());
            loadToUpdate.setShipperId(updatedLoad.getShipperId());
            loadToUpdate.setDate(updatedLoad.getDate());
            return loadRepository.save(loadToUpdate);
        } else {
            return null;
        }
    }

    public void deleteLoad(Long loadId) {
        loadRepository.deleteById(loadId);
    }

    public List<Load> findByShipperId(String shipperId) {
        return null;
    }
}
