package next.level.demo.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sys_requirements", schema = "nextlevel", catalog = "")
public class SysRequirement {
    private int id;
    private String cpu;
    private String gpu;
    private String memory;
    private String storage;
    private String os;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cpu")
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Basic
    @Column(name = "gpu")
    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    @Basic
    @Column(name = "memory")
    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Basic
    @Column(name = "storage")
    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Basic
    @Column(name = "os")
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
        return id == that.id &&
                Objects.equals(cpu, that.cpu) &&
                Objects.equals(gpu, that.gpu) &&
                Objects.equals(memory, that.memory) &&
                Objects.equals(storage, that.storage) &&
                Objects.equals(os, that.os);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpu, gpu, memory, storage, os);
    }
}
