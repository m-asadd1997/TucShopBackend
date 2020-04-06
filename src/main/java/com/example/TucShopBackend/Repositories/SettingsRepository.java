package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingsRepository extends JpaRepository<Settings,Long > {

    public Settings findSettingByHeaderAndFooter(String header,String footer);
}
