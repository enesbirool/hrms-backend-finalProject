package kodlamaio_birol.hrms.core.services;

import kodlamaio_birol.hrms.entities.concretes.JobSeeker;

public interface HumanChecker {
    boolean isValid(JobSeeker jobSeeker);
}