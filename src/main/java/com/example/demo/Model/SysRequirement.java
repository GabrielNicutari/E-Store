package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "sys_requirements", schema = "nextlevel", catalog = "")
public class SysRequirement {
    private int id;
    private String cpu;
    private String gpu;
    private String memory;
    private String storage;
    private String os;

    public SysRequirement() {}

    public SysRequirement(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cpu", nullable = false, length = 45)
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Basic
    @Column(name = "gpu", nullable = false, length = 45)
    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    @Basic
    @Column(name = "memory", nullable = false, length = 45)
    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Basic
    @Column(name = "storage", nullable = false, length = 45)
    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Basic
    @Column(name = "os", nullable = false, length = 45)
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRequirement that = (SysRequirement) o;

        if (id != that.id) return false;
        if (cpu != null ? !cpu.equals(that.cpu) : that.cpu != null) return false;
        if (gpu != null ? !gpu.equals(that.gpu) : that.gpu != null) return false;
        if (memory != null ? !memory.equals(that.memory) : that.memory != null) return false;
        if (storage != null ? !storage.equals(that.storage) : that.storage != null) return false;
        if (os != null ? !os.equals(that.os) : that.os != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cpu != null ? cpu.hashCode() : 0);
        result = 31 * result + (gpu != null ? gpu.hashCode() : 0);
        result = 31 * result + (memory != null ? memory.hashCode() : 0);
        result = 31 * result + (storage != null ? storage.hashCode() : 0);
        result = 31 * result + (os != null ? os.hashCode() : 0);
        return result;
    }
}
