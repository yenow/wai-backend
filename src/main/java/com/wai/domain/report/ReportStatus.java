package com.wai.domain.report;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ReportStatus {
     report, process, complete, reject,
}
