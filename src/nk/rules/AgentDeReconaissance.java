package nk.rules;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.command.CommandFactory;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

public class AgentDeReconaissance {
	private KnowledgeBase kb;

	public AgentDeReconaissance(String rulesRessource) {
		KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kBuilder.add(ResourceFactory.newClassPathResource(rulesRessource, "UTF-8", this.getClass()),
				ResourceType.DRL);

		if (kBuilder.hasErrors()) {
			throw new RuntimeException(kBuilder.getErrors().toString());
		}

		kb = KnowledgeBaseFactory.newKnowledgeBase();
		kb.addKnowledgePackages(kBuilder.getKnowledgePackages());
	}

	@SuppressWarnings("unchecked")
	public void roule(Object o) {
		StatelessKnowledgeSession session = kb.newStatelessKnowledgeSession();
		session.execute(CommandFactory.newInsert(o));
	}
}
