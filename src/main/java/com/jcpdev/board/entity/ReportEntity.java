package com.jcpdev.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@Table(name = "Report")
public class ReportEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int report_no;

	@Column(nullable = false)
	private String report_content;
	
	@ManyToOne(targetEntity = ClientEntity.class)				
	private ClientEntity c_report;
	
	@ManyToOne(targetEntity = WhiteboardEntity.class)
	private WhiteboardEntity w_report;
	
}
